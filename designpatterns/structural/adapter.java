package structural;
/*
* This demonstrates the Adapter pattern
*
* The class VideoPlayer is an incompatible class with
* MusicPlayer class, so we will create an adapter which
* helps us playing in any media i.e. audio or video.
*
* Note: There are two types to variations for this pattern
* i.e Class adapter and Object adapter. Since Java does not
* support multiple inheritance, the example is the demonstration
* of object inheritance.
*/

// Video Player :: the incompatible class
class VideoPlayer{
	public void videoPlay(String name){
		System.out.println("Video: " + name + " playing...");
	}
}

// Player interface :: defines Player's feature set the client expects
interface Player{
	public void play();
}

class MusicPlayer implements Player{
	private final String name;

	public MusicPlayer(String name){
		this.name = name;
	}

	@Override
	public void play(){
		System.out.println(this.name+" playing...");
	}
}

// As the above MusicPlayer is incompatible wih the VideoPlayer class
// we are going to create an adapter which will make these classes work
// together from client's perspective.
class PlayerAdapter implements Player{
	private final String name;

	public PlayerAdapter(String name){
		this.name = name;
	}

	@Override
	public void play(){
		// get the file extension
		String[] fileNameTokens = this.name.split("\\.");
		if(fileNameTokens[1].equals("mp3")){
			// play the music using Music player
			(new MusicPlayer(this.name)).play();
		} else {
			// play the video file
			(new VideoPlayer()).videoPlay(this.name);
		}
	}
}

// the client, who wants to play the file
class adapter{
	public static void main(String args[]){
		Player player = new PlayerAdapter("MyLife.mp3");
		player.play();
		player = new PlayerAdapter("LifeofPi.avi");
		player.play();
		System.out.println();	
	}
}
