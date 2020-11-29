package teste.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import teste.dao.CursoDAO;

@FacesConverter(value = "cursoConverter", forClass = CursoBean.class)
public class CursoConverter implements javax.faces.convert.Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return new CursoDAO().retrieve(CursoBean.class, Integer.parseInt(value));
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof CursoBean)) {
            return String.valueOf(((CursoBean) value).getId());
        }

        return null;
	}

}
