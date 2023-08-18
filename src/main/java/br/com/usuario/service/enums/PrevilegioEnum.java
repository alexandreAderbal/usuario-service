package br.com.usuario.service.enums;

import java.util.Arrays;
import java.util.List;

public enum PrevilegioEnum {
    LER,GRAVAR,ALTERAR,DELETAR;

    public static List<PrevilegioEnum> getValues(){
        return Arrays.asList(PrevilegioEnum.values());
    }
}
