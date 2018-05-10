package ru.job4j;

import java.util.*;

/**
 * SortDepartments
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortDepartments {
    /**
     * All departments
     */
    private ArrayList<Department> departmentArrayList = new ArrayList<>();

    public void addDep(Department department) {
        departmentArrayList.add(department);
    }

    /**
     * Order departments by asc
     */
    public void orderByAsc() {
        Collections.sort(departmentArrayList);
    }

    /**
     * a
     * Order departments by desc
     */
    public void orderByDesc() {
        Collections.sort(departmentArrayList, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                int result;
                if (o2.getIer() != o1.getIer()) {
                    result = Integer.compare(o2.getIer(), o1.getIer());
                } else {
                    if (o2.getName().length() != o1.getName().length()) {
                        result = Integer.compare(o1.getName().length(), o2.getName().length());
                    } else {
                        result = -o1.getName().compareTo(o2.getName());
                    }
                }
                return result;
            }
        });
    }

    public void show() {
        for (Department dep : departmentArrayList) {
            System.out.println(dep.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortDepartments sortDepartments = new SortDepartments();
        sortDepartments.addDep(new Department("K2", 2));
        sortDepartments.addDep(new Department("K1", 1));
        sortDepartments.addDep(new Department("K1\\SK1", 1));
        sortDepartments.addDep(new Department("K1\\SK1\\SSK2", 1));
        sortDepartments.addDep(new Department("K1\\SK1\\SSK1", 1));
        sortDepartments.addDep(new Department("K1\\SK2", 1));
        sortDepartments.addDep(new Department("K2\\SK1\\SSK1", 2));
        sortDepartments.addDep(new Department("K2\\SK1\\SSK2", 2));
        sortDepartments.addDep(new Department("K2\\SK1", 2));
        sortDepartments.addDep(new Department("K2\\SK2", 2));
        sortDepartments.orderByDesc();
        sortDepartments.show();
    }
}
