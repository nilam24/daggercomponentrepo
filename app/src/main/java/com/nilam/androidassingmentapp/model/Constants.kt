package com.nilam.androidassingmentapp.model

import javax.inject.Inject

//class is for media list creation
//injected through constructor using dagger2
class Constants @Inject constructor() {
    var list = ArrayList<MediaItem>()

    fun setMediaDataList(): List<MediaItem> {
        var mediaItem = MediaItem()
        mediaItem.image =
            "https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/150375812059a18728c0d9b.jpeg"
        mediaItem.url = "https://dl5.webmfiles.org/big-buck-bunny_trailer.webm"
        //"https://www.dropbox.com/s/df2d2gf1dvnr5uj/Sample_1280x720_mp4.mp4"
        //"https://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
        //"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        //"https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
        //"https://techslides.com/demos/sample-videos/small.mp4"

        mediaItem.title = "Anupam Kher in conversation with Johnny Lever"
        mediaItem = MediaItem(mediaItem.title, mediaItem.image, mediaItem.url)
        var mediaItem2 = MediaItem()

        mediaItem2.image =
            "https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/150497447759b4168d9557d.jpeg"
        mediaItem2.title = "In Conversation with Chef Vikas Khanna"
        //mediaItem2.url = "http://uds.ak.o.brightcove.com/5384493731001/5384493731001_5552873278001_5552856451001.mp4?pubId=5384493731001&videoId=5552856451001"
        mediaItem2.url =
            "https://test-videos.co.uk/vids/jellyfish/mp4/h264/720/Jellyfish_720_10s_1MB.mp4"
        //"https://uds.ak.o.brightcove.com/5384493731001/5384493731001_5552873278001_5552856451001.mp4"

        mediaItem2 = MediaItem(mediaItem2.title, mediaItem2.image, mediaItem2.url)

        var mediaItem3 = MediaItem()

        mediaItem3.image =
            "https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15509400745c7177aa10252.jpeg"

        mediaItem3.title = "Nation Wants To Know: Union minister Rajnath Singh Speaks To Bharat"
        mediaItem3.url =
            "https://test-videos.co.uk/vids/sintel/mp4/av1/1080/Sintel_1080_10s_20MB.mp4"

        //"http://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/9ae886bf-c6e9-4b7d-94be-afaa7c848d7a/10s/master.m3u8?fastly_token=NWY0ZmE1OTBfNjVkN2ZlY2JkN2RhNTgzM2RhMjUxZjU5ZGJlZTU0MTFlYTMxY2I0ODljNzI5ZjJmYTYxNjUxOWFjN2I3NDVlYg%3D%3D"

        // "https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/cf26a7ed-219c-4608-b9c2-b9665d9adf35/10s/master.m3u8?fastly_token=NWY0ZTEyYThfNWZlZjhhOWY4NjIxOWZhMDFhZmM5Y2RjMWM4ZjQ0OWMyYWRlNWJjNTRkZmQzMjlmZWFkOGI3M2JjZDNhYzM5ZQ%3D%3D"
        mediaItem3 = MediaItem(mediaItem3.title, mediaItem3.image, mediaItem3.url)

        var mediaItem4 = MediaItem()

        mediaItem4.image =
            "https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15467004525c30c6a42b547.jpeg"
        mediaItem4.title = "Nation Wants To Know: Gautam Gambhir Speaks To Arnab"
        mediaItem4.url =
            "https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/1080/Big_Buck_Bunny_1080_10s_20MB.mp4"

        //  "https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/33780241-39b5-4a0f-909c-b92b860c5b5c/10s/master.m3u8?fastly_token=NWY0ZTE2OWZfZjM0NDZkZTA5ZWQ2NjJmZWI0YjZmOTJmMjA5YzdjYjc0NDhjMGU4YzBmMDQ5MzRiODNiYzZiZWUzMTdiZjQ4NQ%3D%3D"
        mediaItem4 = MediaItem(mediaItem4.title, mediaItem4.image, mediaItem4.url)

        var mediaItem5 = MediaItem()

        mediaItem5.image =
            "https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15473142655c3a2459d525a.jpeg"
        mediaItem5.title =
            "Nation Wants To Know: Union minister Col Rajyavardhan Rathore Speaks To Arnab"
        mediaItem5.url =
            "https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/9ae886bf-c6e9-4b7d-94be-afaa7c848d7a/10s/master.m3u8?fastly_token=NWY0ZmE1OTBfNjVkN2ZlY2JkN2RhNTgzM2RhMjUxZjU5ZGJlZTU0MTFlYTMxY2I0ODljNzI5ZjJmYTYxNjUxOWFjN2I3NDVlYg%3D%3D"
        mediaItem5 = MediaItem(mediaItem5.title, mediaItem5.image, mediaItem5.url)

        var mediaItem6 = MediaItem()

        mediaItem6.image =
            "https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15944845855f09e769daee4.jpeg"
        mediaItem6.title =
            "#ISROChiefSpeaksToArnab"
        mediaItem6.url =
            "https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/701d3530-abce-4a5c-9169-8c0b2b4c4429/10s/master.m3u8?fastly_token=NWY0ZTBlZjFfNTVkYmY0OGI1Y2Y3ZjRjMjgzMzBkNGZhNGI5MmUzY2VjYjdiYzdjNTZhOWIwYzUzZGFiZjgwZTg2ZWQ0ZmJmNA%3D%3D"
        mediaItem6 = MediaItem(mediaItem6.title, mediaItem6.image, mediaItem6.url)

        list.add(mediaItem)
        list.add(mediaItem2)
        list.add(mediaItem3)
        list.add(mediaItem4)
        list.add(mediaItem5)
        list.add(mediaItem6)
        return list

    }

}