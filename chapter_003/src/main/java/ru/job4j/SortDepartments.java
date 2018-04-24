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
    private Set<Org> organizations = new HashSet<>();

    /**
     * Constructor
     *
     * @param orgs org
     */
    public SortDepartments(Org... orgs) {
        for (Org organization : orgs) {
            organizations.add(organization);
        }
    }

    /**
     * Order departments by asc
     */
    public void orderByAsc() {
        for (Org organiz : organizations) {
            Collections.sort(organiz.get(), new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] firstStr = o1.split("[\\\\s\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@]+");
                    String[] secondStr = o2.split("[\\\\s\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@]+");
                    int length = firstStr.length > secondStr.length ? secondStr.length : firstStr.length;
                    int result = 0;
                    for (int i = 0; i < length; i++) {
                        if (firstStr[i].compareTo(secondStr[i]) != 0) {
                            result = firstStr[i].compareTo(secondStr[i]) > 0 ? -1 : 1;
                            break;
                        } else {
                            if (firstStr.length == length && secondStr.length == length) {
                                result = o1.compareTo(o2) > 0 ? -1 : 1;
                                break;
                            }
                            if (firstStr.length == length) {
                                result = -1;
                                break;
                            }
                            if (secondStr.length == length) {
                                result = 1;
                                break;
                            }
                        }
                    }
                    return result;
                }
            });
            organiz.showDepartments();
        }
    }

    /**
     * Order departments by desc
     */
    public void orderByDesc() {
        for (Org organiz : organizations) {
            Collections.sort(organiz.get());
            organiz.showDepartments();
        }
    }

    public static void main(String[] args) {
        Org or= new Org();
        or.add("K2");
        or.add("K1");
        or.add("K1\\SK1");
        or.add("K1\\SK1\\SSK2");
        or.add("K1\\SK1\\SSK1");
        or.add("K1\\SK2");
        or.add("K2\\SK1\\SSK1");
        or.add("K2\\SK1\\SSK2");
        or.add("K2\\SK1");
        SortDepartments sortDepartments = new SortDepartments(or);
        sortDepartments.orderByAsc();
        sortDepartments.orderByDesc();
    }
}
