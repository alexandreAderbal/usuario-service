package br.com.usuario.service.enums;

import java.util.Arrays;
import java.util.List;

public enum PermissaoEnum {
    USUARIO,PERMISSAO,PREVILEGIO;

    public static List<PermissaoEnum> getValues(){
        return Arrays.asList(PermissaoEnum.values());
    }
}
