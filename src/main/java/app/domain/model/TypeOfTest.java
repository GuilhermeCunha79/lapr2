package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class TypeOfTest {

    private String code;
    private String description;
    private String collectingMethod;
    private String category;

    public TypeOfTest(String code, String description, String collectingMethod, String category){
        setCode(code);
        setDescription(description);
        setCollectingMethod(collectingMethod);
        this.code = code;
        this.description = description;
        this.collectingMethod = collectingMethod;
        this.category = category;
    }

    public String getCode() { return code; }

    public String getDescription() { return description; }

    public String getCollectingMethod() { return collectingMethod; }

    public void setCode(String code) {
        if(code==null)
            throw new NullPointerException("Code cannot be null.");
        if (code.length() != 5)
            throw new IllegalArgumentException("Code needs to have exactly 5 chars");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank");

        for (int i = 0; i < code.length(); i++) {
            String c = String.valueOf(code.charAt(i));
            if (!c.matches("[A-Za-z0-9]"))
                throw new IllegalArgumentException("Code has non alphanumeric chars.");
        }
        this.code = code;
    }

    public void setDescription(String description) {
        if(description==null)
            throw new NullPointerException("Description cannot be null.");
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank.");
        if (description.length() > 15)
            throw new IllegalArgumentException("Description cannot have more than 15 chars.");
        this.description = description;
    }

    public void setCollectingMethod(String collectingMethod) {
        if(collectingMethod==null)
            throw new NullPointerException("Collecting method cannot be null.");
        if(StringUtils.isBlank(collectingMethod))
            throw new IllegalArgumentException("Collecting method cannot be blank");
        if (collectingMethod.length() > 20)
            throw new IllegalArgumentException("Too long collecting method has more than 20 chars");
        this.collectingMethod = collectingMethod;
    }

    @Override
    public String toString() {
        return String.format("Type of Test: %nCode: %s%nDescription: %s%nCollectingMethod: %s%nCategory %s ", this.code, this.description, this.collectingMethod, this.category  );

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfTest newTot = (TypeOfTest) obj;
        return code == newTot.code || description.equals(newTot.description) &&
                collectingMethod.equals(newTot.collectingMethod);
    }
}

