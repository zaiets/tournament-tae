package models.definitions;

import org.springframework.stereotype.Component;
import models.utils.FileReaderForINI;

import java.util.Arrays;
import java.util.List;

@Component
public enum PossibleDisciplines {
    ALL;

    private static final String DEFAULT_DISCIPLINES_LIST_PATH = "Disciplines.ini";

    private List<String> disciplines;

    {
        List<String> defaultDisciplinesList = Arrays.asList("Sparring", "Special_technique", "Tul");
        disciplines = FileReaderForINI.readIniAsList(DEFAULT_DISCIPLINES_LIST_PATH)
                .orElse(defaultDisciplinesList);
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<String> disciplines) {
        this.disciplines = disciplines;
    }

}
