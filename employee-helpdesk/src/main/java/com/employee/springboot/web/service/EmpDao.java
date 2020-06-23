package com.employee.springboot.web.service;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.employee.springboot.web.model.*;

import com.employee.springboot.web.model.Emp;  
 
@Service
public class EmpDao {  
	
//	@Autowired
//    private DataSource dataSource;
	
	@Autowired
    private JdbcTemplate template;
	
//    public void setDataSource(DataSource dataSource) {
//            this.dataSource = dataSource;
//            this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

//JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Emp p, String name){  
    String sql="insert into employee_ticket (USER_ID, USER_NAME, TICKET_DESC) values('"+p.getUser_id()+"','"+p.getUser_name()+"','"+p.getTicket_desc()+"')";  
    return template.update(sql);  
}  
public int update(Emp p){  
    String sql="update employee_ticket set TICKET_DESC='"+p.getTicket_desc()+"' where TICKET_ID='"+p.getTicket_id()+"'";  
    return template.update(sql);  
}  
public int delete(int ticket_id){  
    String sql="delete from employee_ticket where ticket_id="+ticket_id+"";  
    return template.update(sql);  
}  
public Emp getEmpById(int ticket_id){  
    String sql="select * from employee_ticket where ticket_id=?";  
    return template.queryForObject(sql, new Object[]{ticket_id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}  
public List<Emp> getEmployees(String name){  
	String sql = "select * from employee_ticket where USER_ID=?";
    return template.query(sql,new Object[]{name}, new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setUser_id(rs.getString(1));  
            e.setUser_name(rs.getString(2));  
            e.setTicket_id(rs.getInt(3));  
            e.setTicket_desc(rs.getString(4));
            System.out.println("Printing");
            System.out.println(e);
            System.out.println("----------");
            return e;  
        }  
    });  
}

public Emp getEmpByName(String name){  
    String sql="select * from employee_ticket where user_id=?";  
    return template.queryForObject(sql, new Object[]{name},new BeanPropertyRowMapper<Emp>(Emp.class));  
} 


public String loginUser(User user) {
	
	String sql = "SELECT USER_ID FROM USER_DATA WHERE USER_ID=? AND USER_PASS=?";
	
	try {

		String userId = template.queryForObject(sql, new Object[] {
				user.getUserId(), user.getPassword() }, String.class);

		return userId;
		
	} catch (Exception e) {
		return null;
	}
}

public int registerUser(User user) {
	
	String sql = "INSERT INTO USER_DATA VALUES(?,?)";

	try {
		
		int counter = template.update(sql, new Object[] { user.getUserId(), user.getPassword() });

		return counter;

	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
}


}  