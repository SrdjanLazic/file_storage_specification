package rs.edu.raf.storage.enums;

/**
 * Operacije koje predstavljaju mogucnost pretrage fajlova prilikom listanja
 * FILTER_EXTENSION za ciljanu ekstenziju
 * FILTER_FILENAME za pronalazenje upisane reci medju imenima fajlova
 * FILTER_BY_NAME pretraga po imenu po uzlaznimm ili silaznim slovima sortirano
 * FILTER_BY_DATE pretraga po datumu ili kreiranja ili modifikovanja fajlova sortirano
 */
public enum Operations {
    FILTER_EXTENSION, FILTER_FILENAME, SORT_BY_NAME_ASC, SORT_BY_NAME_DESC, SORT_BY_DATE_CREATED, SORT_BY_DATE_MODIFIED_ASC, SORT_BY_DATE_MODIFIED_DESC
}
