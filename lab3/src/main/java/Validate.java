import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate implements Validator {
    private Error e = new Error();

    private static final String LOGIN_VALIDATE = "^[A-Za-z]+";

    private Pattern pattern;

    public Validate() {
        pattern = Pattern.compile(LOGIN_VALIDATE);
        e.errors("ERROR_LOGIN");
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o)
            throws ValidatorException {
        Matcher matcher = pattern.matcher(o.toString());
        if (!matcher.matches()) {
            FacesMessage facesMessage = new FacesMessage(e.getError());
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
}

