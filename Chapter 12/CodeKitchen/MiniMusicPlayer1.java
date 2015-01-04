import javax.sound.midi.*;
/*
	This class creates a sequencer object to play a sequence object that is created in the next couple lines
	A track is created and a bunch of midi events are added to that track.
	Make event is the static class added on the bottom in order to send messages to the sequencer with ease.
	then we set the sequencer to have the sequence we just created a track for, set the time and start it
	Hoping we don't get an exception.
	there is no playback or display of anything from this program it's simply an example to show how the
	static MidiEvent method works.
*/

public class MiniMusicPlayer1
{

	public static void main(String[] args)
	{

		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();


			for(int i = 5; i < 61; i+= 4)
			{
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
		
		sequencer.setSequence(seq);
		sequencer.setTempoInBPM(220);
		sequencer.start();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
	{
		MidiEvent event = null;

		try
		{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		}
		catch(Exception e)
		{}
		return event;
	}
}