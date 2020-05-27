import react.*
import react.dom.*
import kotlin.browser.window
import kotlinx.html.js.onClickFunction

external interface VideoListProps: RProps{
    var videos:List<Video>
    var selectedVideo:Video?
    var onSelectVideo:(Video) ->Unit
}

external interface VideoListState: RState{
    var selectedVideo: Video?
}



class VideoList : RComponent<VideoListProps,RState>(){
    override fun RBuilder.render(){

        for(video in props.videos){
            p{
                key = video.id.toString()
                attrs{
                    onClickFunction ={
                            props.onSelectVideo(video)
                        }
                    }
                    if(video == props.selectedVideo){
                        +">"
                }
                    else{
                        +"-"
                    }


                +"${video.speaker} : ${video.title}"
            }
            }
        }
    }



fun RBuilder.videoList(handler:VideoListProps.()->Unit):ReactElement{
    return child(VideoList::class){
        this.attrs(handler)
    }
}