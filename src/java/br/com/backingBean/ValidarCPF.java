/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backingBean;

import br.com.control.Validar;
import com.sun.faces.taglib.jsf_core.ValidatorTag;
import javax.faces.validator.Validator;
import javax.servlet.jsp.JspException;

/**
 *
 * @author lucas_000
 */
public class ValidarCPF extends ValidatorTag {

    public ValidarCPF() {
        super();
        setId("Validacao");
    }

    @Override
    protected Validator createValidator() throws JspException {
        return new Validar();
    }
}
