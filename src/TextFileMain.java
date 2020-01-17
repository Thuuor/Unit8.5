import java.io.IOException;

public class TextFileMain {

	public static void main(String[] args) throws IOException {

		sortedTextFile sf1 = new sortedTextFile("ejemplo1");
		sortedTextFile sf2 = new sortedTextFile("ejemplo2");
		
		sortedTextFile.merge(sf1, sf2, "Resultado");
	}

}
