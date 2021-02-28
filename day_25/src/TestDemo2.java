import java.util.*;
public class TestDemo2 {
    private final static char[] NUM = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '拾',
            '佰', '仟', '万', '亿'};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            double d = scan.nextDouble();
            System.out.println(convert(d));
        }
    }
    private static String convert(double d) {
        long n = (long) d;

        StringBuilder builder = new StringBuilder("人民币");

        // 处理整数部分，前提是整数部分大于0
        if (n > 0) {
            convert(n, builder);
            builder.append('元');
        }
        // 加上0.0001是为了防止d*100发生失真
        int v = (int) (d * 100 - n * 100 + 0.0001);
        int i = v / 10;
        int j = v % 10;

        if (i == 0 && j == 0) {
            builder.append('整');

            return builder.toString();
        }

        if (i != 0) {
            builder.append(NUM[i]).append('角');
        }

        if (j != 0) {
            builder.append(NUM[j]).append('分');
        }


        return builder.toString();
    }

    private static void convert(long n, StringBuilder builder) {
        // 大于一亿
        if (n >= 1_0000_0000) {
            long q = n / 1_0000_0000;
            long r = n % 1_0000_0000;

            convert(q, builder);
            builder.append('亿');

            // 是亿的整数倍
            if (r != 0) {
                convert(r, builder);
            }
        }
        // 大于一万
        else if (n >= 1_0000) {
            long q = n / 1_0000;
            long r = n % 1_0000;

            convert(q, builder);
            builder.append('万');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 100) {
                    builder.append('零');
                }

                convert(r, builder);
            }
        }
        // 大于一千
        else if (n >= 1000) {
            long q = n / 1000;
            long r = n % 1000;

            convert(q, builder);
            builder.append('仟');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 100) {
                    builder.append('零');
                }

                convert(r, builder);
            }
        }
        // 大于一百
        else if (n >= 100) {
            long q = n / 100;
            long r = n % 100;

            convert(q, builder);
            builder.append('佰');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 10) {
                    builder.append('零');
                }

                convert(r, builder);
            }
        }
        // 大于十
        else if (n >= 10) {
            long q = n / 10;
            long r = n % 10;

            if (q > 1) {
                convert(q, builder);
            }
            builder.append('拾');

            // 是亿的整数倍
            if (r != 0) {
                convert(r, builder);
            }

        } else {
            builder.append(NUM[(int) n]);
        }
    }
}