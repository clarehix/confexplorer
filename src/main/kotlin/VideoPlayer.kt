import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import styled.*

external interface VideoPlayerProps: RProps{
    var video:Video
    var onWatchedButtonPressed:(Video)-> Unit
    var unwatchedVideo:Boolean
}

class VideoPlayer: RComponent<VideoPlayerProps,RState>() {
    override fun RBuilder.render(){
        styledDiv{
            css{
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3{
                +"${props.video.speaker}: ${props.video.title}"
            }
            styledButton{
                css{
                    display = Display.block
                    backgroundColor = if(props.unwatchedVideo)Color.lightCoral else Color.paleGoldenrod
                }
                attrs{
                    onClickFunction ={
                        props.onWatchedButtonPressed(props.video)
                    }
                }
                if(props.unwatchedVideo){
                    +"Mark as watched"
                }
                else{
                    +"Mark as unwatched"
                }
            }
            img{
                attrs{
                    src = "https://www.bing.com/images/search?view=detailV2&ccid=CbdzSV3w&id=1284008F8608813CD55E7F85EBA367BAF992F609&thid=OIP.CbdzSV3wjBjHBk13IXcECAHaEK&mediaurl=https%3a%2f%2fjdrf.org.uk%2fwp-content%2fuploads%2f2017%2f06%2fplaceholder-image.jpg&exph=1080&expw=1920&q=placeholder+image&simid=608041758312629948&selectedIndex=0&ajaxhist=0"
                }
            }

        }
    }
}

fun RBuilder.videoPlayer(handler:VideoPlayerProps.() -> Unit):ReactElement{
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}


