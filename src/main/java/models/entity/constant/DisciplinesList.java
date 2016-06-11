package models.entity.constant;

import org.springframework.stereotype.Component;
import utils.FileReaderForINI;

import java.util.Arrays;
import java.util.List;

@Component
public enum DisciplinesList {
    INSTANCE;

    private static final String DEFAULT_DISCIPLINES_LIST_PATH = "Disciplines.ini";

    private List<String> allDisciplines;

    {
        List<String> defaultDisciplinesList = Arrays.asList("Sparring", "Special_technique", "Tul");
        allDisciplines = FileReaderForINI.readIniAsList(DEFAULT_DISCIPLINES_LIST_PATH)
                .orElse(defaultDisciplinesList);
    }

    public List<String> getAllDisciplines() {
        return allDisciplines;
    }

    public void setAllDisciplines(List<String> allDisciplines) {
        this.allDisciplines = allDisciplines;
    }

}
