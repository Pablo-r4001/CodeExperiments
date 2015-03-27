import javax.sound.midi.*;

/*
	La clase lleva por nombre MiniMusicPlayer2 e implementa la Interfaz "ControllerEventListener"

	Esta aplicación tinee un main que crea una instancia de la clase "MiniMusicPlayer2" (misma donde se encuentra) y corre el método go
	Go hace un try en que llama un Sequenciador nuevo y lo abre, crea un int[] llamado events I want que crea un nuevo evento vacio
	en la linea de abajo agregando al "ControllerEventListener"
	Se crea una nueva secuencia de 4 beats.
	se realiza un for que agrega 4 a una int i de 5 hasta llegar al último no. menor a 60
	se agrega al track creado junto con el secuenciador un menasje de evento el cual es mandado por el método "MakeEvent"
	El Método Make event regresa un mensaje llamado Event el cual es recibido por el Método ControlChange que será descrito más adelante

*/

public class MiniMusicPlayer2 implements ControllerEventListener
{
	public static void main (String[] args)
	{
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}

	public void go()
	{
		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for(int i = 5; i < 60; i+=4)
			{
				track.add(makeEvent(144,1,i,0,i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,i,0,i+2));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}
		catch (Exception ex) {ex.printStackTrace();}
	}

	public void controlChange(ShortMessage event)
	{
		System.out.println("la");
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