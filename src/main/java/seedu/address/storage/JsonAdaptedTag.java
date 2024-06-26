package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagStatus;
import seedu.address.model.tag.TagType;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedTag {

    private final String tagName;
    private final TagStatus tagStatus;
    private final TagType tagType;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTag(@JsonProperty("tagName") String tagName,
                          @JsonProperty("tagStatus") TagStatus tagStatus,
                          @JsonProperty("tagType") TagType tagType) {
        this.tagName = tagName;
        this.tagStatus = tagStatus;
        this.tagType = tagType;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedTag(Tag source) {
        tagName = source.getTagName();
        tagStatus = source.getTagStatus();
        tagType = source.getTagType();
    }

    @JsonProperty("tagName")
    public String getTagName() {
        return tagName;
    }

    @JsonProperty("tagStatus")
    public TagStatus getTagStatus() {
        return tagStatus;
    }

    @JsonProperty("tagType")
    public TagType getTagType() {
        return tagType;
    }


    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Tag toModelType() throws IllegalValueException {
        if (!Tag.isValidTagName(tagName)) {
            throw new IllegalValueException(Tag.MESSAGE_CONSTRAINTS);
        }
        return Tag.createTag(tagName, tagStatus);
    }

}
