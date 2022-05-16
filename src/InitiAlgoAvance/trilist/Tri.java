package InitiAlgoAvance.trilist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class Tri {

        public static List<Integer> triT(List<Integer> table){
            List<Integer> inf = new ArrayList<>();
            List<Integer> sup = new ArrayList<>();
            List<Integer> pivots = new ArrayList<>();
            if(table.size()<=1){
                return table;
            }else {
                int pivot = table.get(table.size() / 2);
                for (int i = 0; i < table.size(); i++) {
                    if (table.get(i) < pivot) {
                        inf.add(table.get(i));
                    } else if (table.get(i) > pivot) {
                        sup.add(table.get(i));
                    } else {
                        pivots.add(table.get(i));
                    }
                }
                List<Integer> tri = new ArrayList<>();
                tri.addAll(triT(inf));
                tri.addAll(pivots);
                tri.addAll(triT(sup));
                return tri;
            }
        }

        public static void main(String[] args) {
            Random random = new Random();

            List<Integer> table = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                table.add(random.nextInt(100)+1);
            }
            for (Integer integer :table) {
                System.out.print(integer + " ");
            }
            System.out.println();
            table = triT(table);
            for (Integer integer :table) {
                System.out.print(integer + " ");
            }
        }
    }