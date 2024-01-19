package och10;

//DTO --> Data 전달하는 객체 단위 ( 일반적 Table 단위) 
// 자바에서만 쓰면 DTO , HTML 과 자바 연결해서 쓰면 자바빈즈라고 한다.  
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
