
public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
{
	MidiEvent event = null;

	try
	{
		SortMessage a = new ShortMessage();
		a.setMessage(comd, chan, one, two);
		event = new MidiEvent(a, tick);
	}
	catch(Exception e)
	{}
	return event;
}