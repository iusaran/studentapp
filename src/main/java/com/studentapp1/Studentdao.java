package com.studentapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Studentdao {
	public boolean addStudent(Studentdto dto) {
		boolean res = false;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saran?user=root&password=Root");
			pstm = con.prepareStatement("insert into studentdetails values (?,?,?)");
			pstm.setInt(1, dto.getSid());
			pstm.setString(2, dto.getSname());
			pstm.setDouble(3, dto.getSper());
			int nori = pstm.executeUpdate();
			if (nori == 1) {
				res = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public boolean deleteStudent(int sid) {
		boolean res = false;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saran?user=root&password=Root");
			pstm = con.prepareStatement("delete from studentdetails where sid= ?");
			pstm.setInt(1, sid);
			int nori = pstm.executeUpdate();
			if (nori == 1) {
				res = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public List<Studentdto> getAllStudents()
	{
		List<Studentdto> students=new ArrayList();
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saran?user=root&password=Root");
			pstm=con.prepareStatement("select * from studentdetails");
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()) {
				Studentdto dto=new Studentdto();
				dto.setSid(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setSper(rs.getDouble(3));
				students.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstm!=null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return students;
	}

	public Studentdto searchStudent(int sid) {
		Studentdto dto=null;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saran?user=root&password=Root");
			pstm=con.prepareStatement("select * from studentdetails where sid=?");
			pstm.setInt(1, sid);
			
			ResultSet rs=pstm.executeQuery();
			if(rs.next())
			{
				dto=new Studentdto();
				dto.setSid(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setSper(rs.getDouble(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstm!=null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return dto;
	}
}