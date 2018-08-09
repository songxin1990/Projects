package com.song.solution.sillychanllenges;

import java.io.*;
import java.util.*;

/**
 * Created by 001844 on 2018/1/2.
 * You start with a data file that lists the number of red-haired students
 * in each grade, in each school, in each city, and in each state.
 * example:
 * state     city            school            grade
 * NY        NYC             PS 122            K1000
 * <p>
 * NY        NYC             PS 122            12000
 * <p>
 * NY        NYC             PS 122            43000
 * <p>
 * NY        NYC             St-Judes          40043
 * <p>
 * NY        NYC             St-Judes          50057
 * <p>
 * result:
 * PS 122                 6000
 * St-Judes                100
 * NYC                  6100
 */
public class Sums {
    /**
     * 首先生成datafile，按照以上格式，之后读取文件，输出结果文件。
     * 年级的红发学生控制在100以内，state5个，city50个以内，school 500以内，grade10个年级
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
//        File dataFile = genDatafile();
        File dataFile = new File("dataFile.txt");
        genResultFile(dataFile);

    }

    private static File genDatafile() throws IOException {
        String input = "dataFile.txt";
        File dataFile = new File(input);
        PrintWriter pw = new PrintWriter(new FileWriter(dataFile));
        pw.write(header());

        final Random random = new Random(47);
        int stateNum = random.nextInt(5);
        int cityNum = random.nextInt(50);
        int schoolNum = random.nextInt(100);
        int gradeNum = 10;
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < stateNum; i++) {
            String state = "state-" + i;
            for (int j = 0; j < cityNum; j++) {

                String city = "city-" + j;
                for (int k = 0; k < schoolNum; k++) {
                    String school = "school-" + k;
                    for (int l = 0; l < gradeNum; l++) {
                        String grade = "grade-" + l;
                        int redHairStudentNum = random.nextInt(30);
                        //write to file
                        StringBuilder sb = new StringBuilder();
                        sb.append(state).append("\t").append(city).append("\t").append(school).append("\t").append(grade).append("\t").append(redHairStudentNum).append("\n");
                        pw.write(sb.toString());
                    }
                }
            }
        }
        pw.flush();
        pw.close();
        return dataFile;
    }

    /**
     * 计算总数，state-1的红发学生人数，state-1-city-1的红发学生人数
     * 数据结构选什么？Map<String,Map<String,Map<String,Map<String,>>
     * 就是Map<State,Map<City,Map<School,Integer>>>
     * 不好，直接用-凭借起来吧，比如state-1-city-1,state-1_city-1_school-1
     */
    private static void genResultFile(File dataFile) throws IOException {
        String output = "sumResult.txt";
        BufferedReader br = new BufferedReader(new FileReader(dataFile));
        //为什么返回文件了，读取一行，计算一行，然后输出最终的结果，使用=====分开，这样不是很Cool？
        String nextLine = null;
        String header = br.readLine();//读取头部
        final Map<String, Integer> map = new HashMap<String,Integer>();
        while ((nextLine = br.readLine()) != null) {
//            System.out.println(nextLine);
            String[] strs = nextLine.split("\t");
            String state = strs[0];
            String city = strs[1];
            String school = strs[2];
            String grade = strs[3];
            int redHairStudents = Integer.valueOf(strs[4]);
            updateMap(map, state, redHairStudents);
            updateMap(map, state + "_" + city, redHairStudents);
            updateMap(map, state + "_" + city + "_" + school, redHairStudents);
//            updateMap(map, state + "_" + city + "_" + school + "_" + grade, redHairStudents);
        }

        System.out.println(map.toString());
    }

    private static void updateMap(final Map<String, Integer> map, String key, Integer num) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + num);
        } else {
            map.put(key, num);
        }
    }


    private static String header() {
        return "state\tcity\tschool\tgrade\tredHairStudents\n";
    }

}
