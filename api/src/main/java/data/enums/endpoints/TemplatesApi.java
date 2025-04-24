package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemplatesApi {

    TEMPLATES("/wbrt/templates"),
    TEMPLATES_USCN("/wbrt/templates?uscn=%s"),
    TEMPLATES_TYPE("/wbrt/templates?type=%s"),
    TEMPLATES_GUID("/wbrt/templates/%s"),
    TEMPLATES_USCN_TYPE("/wbrt/templates?uscn=%s&type=%s");

    private final String path;

}