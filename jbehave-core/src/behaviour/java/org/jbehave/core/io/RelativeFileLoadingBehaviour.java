package org.jbehave.core.io;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.jbehave.core.io.LoadFromRelativeFile.intellijProjectTestStoryFilePath;
import static org.jbehave.core.io.LoadFromRelativeFile.mavenModuleTestStoryFilePath;

import org.jbehave.core.io.stories.MyPendingStory;
import org.junit.Test;

public class RelativeFileLoadingBehaviour {

    @Test
    public void shouldLoadStoryFromFileWithRelativeFilePath() {
        // Given
        String storyPath = "org/jbehave/core/io/stories/MyPendingStory.txt";
        String storyAsText = "Given my step";

        // When
        StoryLoader loader = new LoadFromRelativeFile(CodeLocations.codeLocationFromClass(MyPendingStory.class),
                mavenModuleTestStoryFilePath("src/behaviour/java"),
                intellijProjectTestStoryFilePath("src/behaviour/java"));
        // Then
        assertThat(loader.loadStoryAsText(storyPath), equalTo(storyAsText));

    }

}