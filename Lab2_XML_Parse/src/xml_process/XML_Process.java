package xml_process;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class XML_Process {
	// take 1000 record of xml file
	public void process_xml() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(System.getProperty("user.dir") + "/xml/dblp.xml")));
			PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + "/bin/processed_dblp.xml");
			String temp;
			int count = 0;
			while ((temp = br.readLine()) != null) {
				if (temp.startsWith("<article") || temp.startsWith("<inproceedings") || temp.startsWith("<proceedings")
						|| temp.startsWith("<book") || temp.startsWith("<incollection") || temp.startsWith("<phdthesis")
						|| temp.startsWith("<masterthesis") || temp.startsWith("<www")) {
					count++;
				}
				if (count == 1001)
					break;
				writer.write(temp + "\n");
			}

			writer.write("\n </dblp>");
			writer.close();
			br.close();
			System.out.println("Finished processing " + (count - 1) + " records");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
