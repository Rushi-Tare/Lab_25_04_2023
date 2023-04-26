package Lab;

public class CalculatorSimulator {

	
	class CountryNotValidException extends RuntimeException
	{
		public CountryNotValidException(String message)
		{
			super(message);
		}
	}

	class EmployeeNameInvalidException extends RuntimeException
	{
		public EmployeeNameInvalidException(String message)
		{
			super(message);
		}
	}

	class TaxNotEligibleException extends RuntimeException
	{
		public TaxNotEligibleException(String message)
		{
			super(message);
		}
	}

	class TaxCalculator{
		
		public double calculateTax (String empName,boolean isIndian,double empSal) throws CountryNotValidException,EmployeeNameInvalidException,TaxNotEligibleException
		{
			double taxAmount=0;
			if(isIndian==false) {
				throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
			}
			if(empName.length()==0)
			{
				throw new EmployeeNameInvalidException("The employee name cannot be empty");
			}
			if(empSal<10000) {
				throw new TaxNotEligibleException("The employee does not need to pay tax");
			}
			if (empSal > 100000 && isIndian) {
	        taxAmount = empSal * 8 / 100;
	    
			} 
			else if (empSal > 50000 && empSal <= 100000 && isIndian) {
	        taxAmount = empSal * 6 / 100;
			} 
			else if (empSal > 30000 && empSal <= 50000 && isIndian) {
	        taxAmount = empSal * 5 / 100;
			} 
			else if (empSal > 10000 && empSal <= 30000 && isIndian) {
	        taxAmount = empSal * 4 / 100;
			} 
			else {
	        throw new TaxNotEligibleException("The employee does not need to pay tax");
	    }
			
			return taxAmount;
		}
	}
	//Main class
	public class CalculatorSimulator {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your name.");
			String name = sc.nextLine();
			System.out.println("Enter true if Indian and false if not");
			boolean indian = sc.nextBoolean();
			System.out.println("Enter your salary");
			double salary = sc.nextDouble();
			TaxCalculator obj = new TaxCalculator();
			
			try {
				double tax = obj.calculateTax(name, indian, salary);
				System.out.println(tax);
			}
			catch(CountryNotValidException | EmployeeNameInvalidException | TaxNotEligibleException e  )
			{
				System.out.println(e.getMessage());
			}
//			catch (CountryNotValidException e)
//			{
//				System.out.println(e.getMessage());
//			}
//			catch (EmployeeNameInvalidException e)
//			{
//				System.out.println(e.getMessage());
//			}
//			catch (TaxNotEligibleException e)
//			{
//				System.out.println(e.getMessage());
//			}

//			try {
//		        double tax = obj.calculateTax(name, indian, salary);
//		        System.out.println("Tax amount is " + tax);
//		    } catch (Exception e) {
//		        try {
//		            throw e;
//		        } catch (CountryNotValidException ex) {
//		            System.out.println("Country not valid: " + ex.getMessage());
//		        } catch (EmployeeNameInvalidException ex) {
//		            System.out.println("Employee name not valid: " + ex.getMessage());
//		        } catch (TaxNotEligibleException ex) {
//		            System.out.println("Not eligible for Tax calculation: " + ex.getMessage());
//		        }
//		        e.printStackTrace();
//			
		}

	}
	
	
}
