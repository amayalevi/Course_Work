/*
 * This Data Class stores the data about the vendor and 
 * Calculates the pay based on the amount of sales
 */
public class SP2018LAB4_Vendor_Amaya {
	
	final int baseSalary = 2500;//base pay for all vendors
	private String name;//to store the vendor's name
	private int iD;//to store the vendor's iD
	private double sales;//to store the vendor's sales
	/*
	 * This is the default Constructor	
	 */
	public SP2018LAB4_Vendor_Amaya()
	{
		this.name ="";
		this.iD = 00000;
		this.sales =0.0;				
	}
	/*
	 * This is the parameter Constructor that 
	 * takes in the values for name, Id, and sales
	 */
	public SP2018LAB4_Vendor_Amaya(String n, int id, double totalSales)
	{
		this.name = n;
		this.iD = id;
		this.sales = totalSales;
	}
	/*
	 * This method calculates and returns the comission
	 * amount based on the amount of sales.
	 */
	public double getComission()
	{
		double comision;
		if(this.sales<=20000)
			comision =0.0;
		else if(sales > 20000 && sales <= 30000)
			comision = (sales-20000)*.035;
		else
			comision = (sales-20000)*.042;
		return comision;
		
	}
	/*
	 * This method calculates the Bonus if sales amount is greater than 30000
	 */
	public double getBonus()
	{
		double bonus;
		if(this.sales > 30000)
			bonus = (this.sales-30000)*.02;
		else
			bonus=0.0;
		return bonus;
	}
	/*
	 * This method calculates the total pay that the 
	 * vendor shall receive based on his sales amount.
	 */
	public double totalPay()
	{
		double total;
		total = this.baseSalary;
		total+= this.getComission();
		total += this.getBonus();
		return total;
	}
	/*
	 * This method returns the reciept displaying all the information 
	 * of the Vendor.
	 */
	public String toString()
	{
		String str="";
		str += "......................................\n";
		str += String.format(" Vendor Name:"+"%24s\n", this.name);
		str += String.format(" Vendor ID:"+"%26d\n", this.iD);
		str += String.format(" Total Sale:"+"%25.0f\n", this.sales);
		str += String.format(" Base Salary:"+"%24d\n", this.baseSalary);
		str += String.format(" Commission:"+"%25.2f\n", this.getComission());
		str += String.format(" Bonus:"+"%30.2f\n", this.getBonus());
		str += String.format(" Total Amount made:"+"%18.2f\n", this.totalPay());
		str += "......................................\n";
		return str;
	}
}
