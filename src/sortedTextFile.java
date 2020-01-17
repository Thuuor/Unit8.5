import java.io.*;

public class sortedTextFile {
	
	public final String name = "temp.txt";
	public String nameFile;

	public sortedTextFile(String nameFile) throws IOException {
		this.nameFile = nameFile;
		File f = new File(nameFile);
		if (!f.exists()) {
			f.createNewFile();
		}
	}
	
	public String getName() {
		return nameFile;
	}
	
	public void put(String line) throws IOException {

		BufferedReader input = null;
		PrintWriter output = null;

		try {
			
			String nextLine = null;
			
			File fInput = new File(nameFile);
			File fOutput = new File(name);
			input = new BufferedReader(new FileReader(fInput));
			output = new PrintWriter(new FileWriter(fOutput));
			
			boolean written = false;
			
			while ((nextLine = input.readLine()) != null){
				if (nextLine.compareTo(line) > 0) {
					if (!written) {
						output.println(line);
						written = true;
					}
				}
				output.println(nextLine);
			}
			
			if (!written) {
				output.println(line);
			}
			
			fOutput.renameTo(fInput);
			
		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}
	
	public int getNumElements() throws IOException {
		BufferedReader input = null;
		
		try {
			input = new BufferedReader(new FileReader(nameFile));
			
			int i = 0;
			
			while (input.readLine() != null ) {
				i++;
			}
			return i;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		
		
		
	}
	
	public String getElementAt(int position) throws IOException {
		
		BufferedReader input = null;
		
		try {
			String line = "";
			input = new BufferedReader(new FileReader(nameFile));
			
			int i = 1;
			
			while ((line = input.readLine()) != null) {
				
				if (i == position) {
					return line;
				}
				i++;
			}
			return line;
		} finally {
			if (input != null) {
				input.close();
			}
		}		
	}
	
	public void removeElementAt(int position) throws IOException {

		BufferedReader input = null;
		PrintWriter output = null;

		try {
			
			String nextLine = null;
			
			File fInput = new File(nameFile);
			File fOutput = new File(name);
			input = new BufferedReader(new FileReader(fInput));
			output = new PrintWriter(new FileWriter(fOutput));
			
			int i = 0;
			while ((nextLine = input.readLine()) != null){
				if (i != position) {
					output.println(nextLine);
				}
				i++;
			}
			
			fOutput.renameTo(fInput);
			
		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}	
	}
	
	public boolean isEmpty() throws IOException { 
		
		BufferedReader input = null;

		try {
			
			input = new BufferedReader(new FileReader(nameFile));
			
			if (input.readLine() != null) {
				return false;
			} else {
				return true;
			}
			
		} finally {
			if (input != null) {
				input.close();
			}
		}	
	}
	
	public void emptyFile() throws IOException {
		
		File fInput = new File(nameFile);
		File fOutput = new File(name);
		
		fOutput.createNewFile();
		fOutput.renameTo(fInput);
	}

	public void print() throws IOException {
		BufferedReader input = null;

		try {
			
			input = new BufferedReader(new FileReader(nameFile));
			
			String s = null;
			
			while((s = input.readLine()) != null) {
				System.out.println(s);
			}
	
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
	
	public boolean existsElement(String s) throws IOException {
		BufferedReader input = null;
		
		try {
			
			input = new BufferedReader(new FileReader(nameFile));
			
			String nextLine = null;
			
			while ((nextLine = input.readLine()) != null){
				if (nextLine.equalsIgnoreCase(s)) {
					return true;
				}
			}
			return false;
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
	
	public static void print(String name) throws IOException {
		sortedTextFile f = new sortedTextFile(name);
		f.print();
	}

	public static void merge(String name1,String name2,String nameOfOutFile) throws IOException {
		BufferedReader input1 = null;
		BufferedReader input2 = null;
		PrintWriter output = null;
		
		try {
			
			input1 = new BufferedReader(new FileReader(name1));
			input2 = new BufferedReader(new FileReader(name2));
			output = new PrintWriter(new FileWriter(nameOfOutFile));
	
			String nextLine1 = input1.readLine();
			String nextLine2 = input2.readLine();
			
			while (nextLine1 != null || nextLine2 != null){
				if (nextLine1 == null) {
					output.println(nextLine2);
					nextLine2 = input2.readLine();
				} else {
					if (nextLine2 == null) {
						output.println(nextLine1);
						nextLine1 = input1.readLine();
					} else {
						if (nextLine1.compareTo(nextLine2) < 0) {
							output.println(nextLine1);
							nextLine1 = input1.readLine();
						} else {
							output.println(nextLine2);
							nextLine2 = input2.readLine();
						}
					}
				}
			}
		} finally {
			if (input1 != null) {
				input1.close();
			}
			if (input2 != null) {
				input2.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}
	
	public static void merge(sortedTextFile sf1, sortedTextFile sf2, String nameOfOutFile) throws IOException {
		merge(sf1.getName(), sf2.getName(), nameOfOutFile);
	}
}
