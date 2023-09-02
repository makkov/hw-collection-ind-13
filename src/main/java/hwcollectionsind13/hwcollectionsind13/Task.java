package hwcollectionsind13.hwcollectionsind13;

import java.util.*;

public class Task {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(List.of(77, 46, 43, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
//        System.out.println("nums = " + nums);
//        task1(nums);
//        task2(nums);

        List<String> strings = new ArrayList<>(List.of("hello", "Hello", "world", "how", "hello", "are", "are", "you"));
//        task3(strings);
        task4(strings);
    }

    /*
    * Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
    * Код должен работать с любой последовательностью и объемом списка чисел.
    * */
    public static void task1(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : nums) {
            if (i % 2 != 0) {
                result.add(i);
            }
        }

        System.out.println(result);
    }

    /*
    * Напишите код, с помощью которого можно напечатать только четные числа
    * без повторений в порядке возрастания.
    * */
    public static void task2(List<Integer> nums) {
        List<Integer> filteredNums = new ArrayList<>();
        for (Integer i : nums) {
            if (i % 2 == 0) {
                filteredNums.add(i);
            }
        }

        Set<Integer> result = new TreeSet<>(filteredNums);

        System.out.println(result);
    }

    /*
    * Напишите код, который выводит в консоль все уникальные слова из списка слов,
    * в котором могут встречаться дубли.
    * */
    public static void task3(List<String> strings) {
        Set<String> uniqueWords = new HashSet<>(strings);
        System.out.println(uniqueWords);
    }

    /*
    * Напишите код, который выводит в консоль все количество дублей из списка слов.
    * Например, у вас есть текст из 6 слов, в котором есть одно слово, которое повторяется.
    * В таком случае в консоли выведется результат "2", то есть то количество элементов,
    * которые повторяются.*
    * */
    public static void task4(List<String> strings) {
        Map<String, Integer> countByWord = new HashMap<>();

        for (String str : strings) {
            //есть ли такое слово в мапе
            if (!countByWord.containsKey(str)) {
                //если такого слова нет, кладем его в мапу и начинаем отсчет с 1
                countByWord.put(str, 1);
            } else {
                //если такое слово есть, увеличиваем его счетчик на 1
                countByWord.put(str, countByWord.get(str) + 1);
            }
        }
    }
}
