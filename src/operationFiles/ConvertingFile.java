package operationFiles;

public class ConvertingFile {

	public double celcius;
	public double kelvin;
	public double faranhite;

	public double getKelvinFromCelcius() {
		kelvin = celcius + 273.15;
		return kelvin;
	}

	public double getFaranhiteFromCelcius() {
		faranhite = 1.8 * celcius + 32;
		return faranhite;
	}

	public double getCelciusFromKelvin() {
		celcius = kelvin - 273.15;
		return celcius;
	}

	public double getFaranhiteFromKelvin() {
		faranhite = 1.8 * getCelciusFromKelvin() + 32;
		return faranhite;
	}

	public double getCelciusFromFaranhite() {
		celcius = (faranhite - 32) / 1.8;
		return celcius;
	}

	public double getKelvinFromFaranhite() {
		kelvin = getCelciusFromFaranhite() + 273.15;
		return kelvin;
	}
}
