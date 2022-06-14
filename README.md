# material-dialogs
To show example dialogs
# Download

Add it in your root settings.gradle at the end of repositories:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven {url 'https://jitpack.io'}
    }
}
```
Add the dependency
```gradle
implementation 'com.github.azizjonhamroyev:material-dialogs:1.0'
```
# Usage
Example:
```kotlin
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dialogs = MaterialDialogs(this)
        binding.customArgb.setOnClickListener {
            dialogs.showColorPicker()
        }

        binding.googlePermission.setOnClickListener {
            dialogs.googleLocationServicePermission()
        }

        binding.googleWifi.setOnClickListener {
            dialogs.wifiConnector()
        }
        binding.selectDateAndTime.setOnClickListener {
            dialogs.showDataAndTimePicker()
        }
        binding.socialNetworks.setOnClickListener {
            dialogs.showSocialNetworkPickers()
        }

    }
}
```


