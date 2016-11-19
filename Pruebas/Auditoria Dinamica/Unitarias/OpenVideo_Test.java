package Unit_Testing;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

import App.Video_Processing;
import App.Video_Reading;

public class OpenVideo_Test {
	
	@Test
	public void openVideoTest() {
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		boolean isOpen = vr.videoIsOpen();
		assertEquals(true, isOpen);
	}

	
	
}
