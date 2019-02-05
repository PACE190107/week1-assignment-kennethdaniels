package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;
import com.revature.utils.JDBCConnectionUtil;

public class RequestDaoImp implements RequestDao{

	@Override
	public boolean submitRequest(int requestAmount, int employeeId) {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "call SUBMIT_REQUEST (?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, requestAmount);
			cs.setInt(2, employeeId);
			if(cs.executeUpdate() >= 0) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean reviewRequest(int status, int managerId, int requestNum) {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "call REVIEW_REQUEST (?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, status);
			cs.setInt(2, managerId);
			cs.setInt(3, requestNum);
			if(cs.executeUpdate() >= 0) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Request> getEmpPending(int eid) {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "select * from reimbursement_table WHERE user_id = '?' AND isapproved is null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			List<Request> allEmpPending = new ArrayList<>();
			while (rs.next()) {
				allEmpPending.add(new Request(
						rs.getInt("requestNum"),
						rs.getInt("requestAmount"),
						rs.getInt("user_id"),
						rs.getInt("isApproved"),
						rs.getInt("resolvedBy"))
						);
			} return allEmpPending;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Request> getEmpResolved(int eid) {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "select * from reimbursement_table WHERE user_id = '?' AND isapproved is not null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			List<Request> allEmpResolved = new ArrayList<>();
			while (rs.next()) {
				allEmpResolved.add(new Request(
						rs.getInt("requestNum"),
						rs.getInt("requestAmount"),
						rs.getInt("user_id"),
						rs.getInt("isApproved"),
						rs.getInt("resolvedBy"))
						);
			} return allEmpResolved;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Request> getSpecificEmpReq(int eid) {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "select * from reimbursement_table WHERE user_id = '?'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			List<Request> allEmpReqs = new ArrayList<>();
			while (rs.next()) {
				allEmpReqs.add(new Request(
						rs.getInt("requestNum"),
						rs.getInt("requestAmount"),
						rs.getInt("user_id"),
						rs.getInt("isApproved"),
						rs.getInt("resolvedBy"))
						);
			} return allEmpReqs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Request> getPendingReqs() {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "select * from reimbursement_table WHERE isapproved is null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			List<Request> allPendingReqs = new ArrayList<>();
			while (rs.next()) {
				allPendingReqs.add(new Request(
						rs.getInt("requestNum"),
						rs.getInt("requestAmount"),
						rs.getInt("user_id"),
						rs.getInt("isApproved"),
						rs.getInt("resolvedBy"))
						);
			} return allPendingReqs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Request> getResolvedReqs() {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "select * from reimbursement_table WHERE isapproved is not null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			List<Request> allResolvedReqs = new ArrayList<>();
			while (rs.next()) {
				allResolvedReqs.add(new Request(
						rs.getInt("requestNum"),
						rs.getInt("requestAmount"),
						rs.getInt("user_id"),
						rs.getInt("isApproved"),
						rs.getInt("resolvedBy"))
						);
			} return allResolvedReqs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
