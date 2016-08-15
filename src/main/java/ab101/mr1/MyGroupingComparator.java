package ab101.mr1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyGroupingComparator extends WritableComparator{

	public MyGroupingComparator() {
		super(Text.class,true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub	
		
		return super.compare(a, b);
	}

}
