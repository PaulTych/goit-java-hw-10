package hw10;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionMethods {
    public String getOddNames(List<String> names) {
        ListIterator<String> iter = names.listIterator();
        int i = 0;
        String strf;
        while (iter.hasNext()) {
            strf = iter.next();
            if (i % 2 == 0) {
                iter.remove();
            } else {
                iter.set(i + "." + strf);
            }
            i++;
        }
        return names.toString();
    }

    public List<String> sortUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public String joinElements(String[] numbers) {
        return Stream.of(numbers)
                .flatMap(number -> Stream.of(number.split("\\s*,\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()).toString();
    }

    public Stream<Long> random(Long a, int c, long m, Long seed) {
        if ((a >= 0 && a < m) && (c >= 0 && c < m) && (seed >= 0 && seed < m)) {
            return Stream.iterate(seed, n -> (a * n + c) % m)
                    .limit(10);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> list1 = first.collect(Collectors.toList());
        List<T> list2 = second.collect(Collectors.toList());
        int length = Math.min(list2.size(), list1.size());
        list1 = list1.subList(0, length);
        list2 = list2.subList(0, length);
        list1.addAll(list2);
        Collections.shuffle(list1);
        return list1.stream();
    }
}
