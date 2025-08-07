package workshop.oop.flexible;
/* 평사원 클래스 */
public class MereClerk extends Employee {
    
    
    public MereClerk (String name, double salary) {
        
    	super(name,salary);
        
        
        
    }
    /*
     * overriding 규칙은 부모가 상속해준 메서드와 Signature가 반드시 같아야함
     * Overide annotation은 overriding 규칙을 컴파일 타입 체크해줌
     * 
     * */
    
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
    
    
}
