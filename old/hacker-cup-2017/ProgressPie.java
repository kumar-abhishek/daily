import java.io.*;

/*
5
0 55 55
12 55 55
13 55 55
99 99 99
87 20 40
 */
 class ProgressPie {

	public static void main(String[] args) {
        String fileName = "/Users/kumar/Desktop/progress_pie.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int tests = Integer.parseInt(br.readLine());
            for(int i=0;i<tests;i++) {
                String line = br.readLine();
                String[] parts = line.split(" ");
                int p = Integer.parseInt(parts[0]);
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                if(p == 0) {
                    System.out.println("Case #" + (i + 1) + ": white");
                    continue;
                }

                double theta = p * 360 / 100;

                if (90.0 - Math.toDegrees(Math.atan2((y - 50.0) , (x - 50))) <= theta && ((x-50)*(x-50) +  (y-50) * (y-50) <= 50*50)) {
                    System.out.println("Case #" + (i + 1) + ": black");
                }
                else {
                    System.out.println("Case #" + (i + 1) + ": white");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
  }







