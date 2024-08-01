import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BaekJoon_10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Member[] array = new Member[T];

        for(int i = 0 ; i < T ; i++) {
            String[] split = br.readLine().split(" ");
            Member member = new Member(Integer.parseInt(split[0]) , split[1] , i);
            array[i] = member;
        }

        Arrays.sort(array, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age == o2.age) {
                    return o1.idx - o2.idx;
                }
                return o1.age - o2.age;
            }
        });

        for(int i = 0 ; i < array.length; i++) {
            Member member = array[i];
            bw.write(member.age + " " + member.name + "\n");
        }

        bw.flush();

    }

    public static class Member {
        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }
}
