import java.util.*;
public class day1 {
    static ArrayList<Integer> expenseReportTwoNumbers(ArrayList<Integer> report, int finding){


            ArrayList<Integer> numbers = new ArrayList<Integer>();
            // int multiply = 0;

            HashSet<Integer> setReport = new HashSet<Integer>();

            for(int i: report){
                setReport.add(i);
            }

            for(int entrie : report){
                int missing = finding - entrie;
                if(setReport.contains(missing)){
                    // System.out.println(entrie);
                    // System.out.println(missing);
                    numbers.add(entrie);
                    numbers.add(missing);
                    return numbers;
                }
            }

            return numbers;
        }

    static ArrayList<Integer> expenseReportThreeNumbers(ArrayList<Integer> report, int finding){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int multiply = 0;

        HashSet<Integer> setReport = new HashSet<Integer>();

        for(int i: report){
            setReport.add(i);
        }
        // System.out.println(numbers);
        for(int entrie : report){
            numbers = expenseReportTwoNumbers(report, finding - entrie);
            if(!numbers.isEmpty()){
                numbers.add(entrie);
                return numbers;
            }
        }

        return numbers;
    }

    static int requestExpenseReport(){
        ArrayList<Integer> report = new ArrayList<Integer>();

        report.add(1786);
        report.add(571);
        report.add(1689);
        report.add(1853);
        report.add(1817);
        report.add(1549);
        report.add(1079);
        report.add(1755);
        report.add(1973);
        report.add(1453);
        report.add(1139);
        report.add(1576);
        report.add(1928);
        report.add(1634);
        report.add(1961);
        report.add(1995);
        report.add(1272);
        report.add(1839);
        report.add(1976);
        report.add(1664);
        report.add(1956);
        report.add(1933);
        report.add(1981);
        report.add(1665);
        report.add(1057);
        report.add(1798);
        report.add(1485);
        report.add(2004);
        report.add(1990);
        report.add(2002);
        report.add(82);
        report.add(1922);
        report.add(1544);
        report.add(201);
        report.add(1730);
        report.add(1607);
        report.add(1597);
        report.add(1098);
        report.add(1490);
        report.add(1955);
        report.add(1194);
        report.add(1733);
        report.add(1245);
        report.add(1761);
        report.add(1709);
        report.add(1143);
        report.add(1828);
        report.add(1450);
        report.add(1569);
        report.add(1997);
        report.add(1943);
        report.add(1555);
        report.add(1958);
        report.add(1176);
        report.add(1858);
        report.add(1937);
        report.add(1560);
        report.add(1979);
        report.add(1962);
        report.add(1658);
        report.add(1959);
        report.add(2007);
        report.add(1636);
        report.add(1460);
        report.add(348);
        report.add(1084);
        report.add(1952);
        report.add(1162);
        report.add(1772);
        report.add(701);
        report.add(1462);
        report.add(1680);
        report.add(1639);
        report.add(1625);
        report.add(1060);
        report.add(1600);
        report.add(1631);
        report.add(1638);
        report.add(1350);
        report.add(1675);
        report.add(1366);
        report.add(1244);
        report.add(1413);
        report.add(994);
        report.add(1533);
        report.add(1199);
        report.add(1653);
        report.add(1902);
        report.add(1340);
        report.add(1819);
        report.add(1676);
        report.add(1081);
        report.add(1953);
        report.add(1993);
        report.add(1652);
        report.add(1214);
        report.add(1815);
        report.add(1977);
        report.add(1939);
        report.add(2000);
        report.add(1879);
        report.add(1948);
        report.add(1982);
        report.add(1983);
        report.add(1247);
        report.add(1969);
        report.add(1149);
        report.add(1682);
        report.add(1456);
        report.add(2001);
        report.add(1674);
        report.add(1531);
        report.add(1464);
        report.add(1243);
        report.add(1511);
        report.add(1867);
        report.add(1479);
        report.add(1873);
        report.add(1136);
        report.add(1087);
        report.add(1651);
        report.add(1855);
        report.add(1122);
        report.add(1505);
        report.add(1974);
        report.add(1692);
        report.add(1992);
        report.add(1361);
        report.add(1666);
        report.add(1100);
        report.add(1193);
        report.add(1978);
        report.add(1529);
        report.add(1903);
        report.add(1510);
        report.add(1152);
        report.add(1514);
        report.add(1591);
        report.add(1753);
        report.add(1744);
        report.add(1985);
        report.add(1459);
        report.add(1954);
        report.add(1579);
        report.add(1307);
        report.add(1975);
        report.add(1934);
        report.add(1589);
        report.add(971);
        report.add(1603);
        report.add(1980);
        report.add(1942);
        report.add(1160);
        report.add(1986);
        report.add(1963);
        report.add(1921);
        report.add(1481);
        report.add(1736);
        report.add(1616);
        report.add(1968);
        report.add(1201);
        report.add(1489);
        report.add(1781);
        report.add(1021);
        report.add(1452);
        report.add(1570);
        report.add(1326);
        report.add(1831);
        report.add(2006);
        report.add(1541);
        report.add(1690);
        report.add(1877);
        report.add(1447);
        report.add(1988);
        report.add(1411);
        report.add(1535);
        report.add(1799);
        report.add(1587);
        report.add(1255);
        report.add(1611);
        report.add(1419);
        report.add(1947);
        report.add(1626);
        report.add(132);
        report.add(1946);
        report.add(1950);
        report.add(1487);
        report.add(1496);
        report.add(1949);
        report.add(1155);
        report.add(1628);
        report.add(1738);
        report.add(2010);
        report.add(1446);
        report.add(1466);
        report.add(1630);
        report.add(1784);
        report.add(1989);
        report.add(1458);
        report.add(1741);

        ArrayList<Integer> result = expenseReportThreeNumbers(report, 2020);
        int multiply = 1;
        for(int i : result){
            System.out.println(i);
            multiply = multiply*i;
        }

        return multiply;
    }
}

