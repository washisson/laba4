import com.sun.xml.internal.ws.api.model.CheckedException;
import java.io.IOException;

public class BuyingException extends IOException {
	public BuyingException(String message){
		super(message);
	}
}
