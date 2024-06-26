package seedu.address.model.tag;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_nullTagName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Tag.createTag(null, TagStatus.INCOMPLETE_GOOD));
    }

    @Test
    public void constructor_nullTagStatus_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Tag.createTag("Test", null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> Tag.createTag(invalidTagName, TagStatus.INCOMPLETE_GOOD));
    }

    @Test
    public void constructor_validTagNameAndValidTagStatus_success() {
        String validTagName = "test";
        assert(Tag.createTag(validTagName, TagStatus.COMPLETE_GOOD) instanceof AssignmentTag);
        assert(Tag.createTag(validTagName, TagStatus.PRESENT) instanceof AttendanceTag);
        assert(Tag.createTag(validTagName, TagStatus.ASSIGNED) instanceof TutorialTag);
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

    @Test
    public void correct_tagType() {
        String validTagName = "test";
        assert(Tag.createTag(validTagName, TagStatus.COMPLETE_GOOD).isAssignment());
        assert(Tag.createTag(validTagName, TagStatus.PRESENT).isAttendance());
        assert(Tag.createTag(validTagName, TagStatus.ASSIGNED).isTutorial());
    }

    @Test
    public void equals_tagsWithTheSameTagName_success() {
        String validTagName = "test";
        Tag tag1 = Tag.createTag(validTagName, TagStatus.DEFAULT_STATUS);
        Tag tag2 = Tag.createTag(validTagName, TagStatus.DEFAULT_STATUS);
        assert(tag1.equals(tag2));
    }

    @Test
    public void equals_theSameTag_success() {
        String validTagName = "test";
        Tag tag1 = Tag.createTag(validTagName, TagStatus.DEFAULT_STATUS);
        assert(tag1.equals(tag1));
    }

    @Test
    public void equals_tagNotEqualToNonTagObjects_success() {
        String validTagName = "test";
        Tag tag1 = Tag.createTag(validTagName, TagStatus.DEFAULT_STATUS);
        assert(!tag1.equals(new Object()));
    }
}
