package workshop.oop.flexible;
/* ���� Ŭ���� */
public class MereClerk extends Employee {
    
    
    public MereClerk (String name, double salary) {
        
    	super(name,salary);
        
        
        
    }
    /*
     * overriding ��Ģ�� �θ� ������� �޼���� Signature�� �ݵ�� ���ƾ���
     * Overide annotation�� overriding ��Ģ�� ������ Ÿ�� üũ����
     * 
     * */
    
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
    
    
}
