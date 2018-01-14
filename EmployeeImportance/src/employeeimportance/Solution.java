/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeimportance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KT
 * Description
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
 * 
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * 
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 * 
 * Example 1:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total
 */
public class Solution
{    
    public int getImportance(List<Employee> employees, int id)
    {
        int result = 0;
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).id == id)
            {
                Employee employee = employees.get(i);
                result = result + employee.importance;
                
                for (int j = 0; j < employee.subordinates.size(); j++)
                {
                    result = result + getImportance(employees, employee.subordinates.get(j));                    
                }
                
                break;
            }
        }

        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Employee> employees= new ArrayList<Employee>();
        
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = new ArrayList();
        e1.subordinates.add(2);
        
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 1;
        e2.subordinates = new ArrayList();
        
        employees.add(e1);
        employees.add(e2);
        
        System.out.println(new Solution().getImportance(employees, 1));
    }
    
}
