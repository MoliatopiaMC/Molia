## Molia

<h5>Molia is a drop-in replacement for <a href="https://github.com/PaperMC/Folia">Folia</a> servers designed for bukkit plugins and customize, and performance built on top of <a href="https://github.com/PaperMC/Folia">Folia</a>.</h5>
</div>

## Features
- Fork of [Folia](https://github.com/PaperMC/Folia) for better performance.
- Micro-optimizations
- Variable entity wake-up
- Bukkit plugins support(May cause some problems)(unsafe)
- 
## Downloads

Downloads can be obtained in the [Releases](https://github.com/Molia/Molia/releases)


## Building

Building a Paperclip JAR for distribution:

```bash
./gradlew applyPatches && ./gradlew createReobfPaperclipJar
```


## License
[![MIT License](https://img.shields.io/github/license/Era4FunMc/Molia?style=flat-square)](LICENSE)

All patches are licensed under the MIT license, unless otherwise noted in the patch headers.

See [PaperMC/Paper](https://github.com/PaperMC/Paper), and [PaperMC/Paperweight](https://github.com/PaperMC/paperweight) for the license of material used by this project.

Yes, this also includes all API provided by Paper, Spigot, and Bukkit.


Credits:
-------------
- [Folia](https://github.com/PaperMC/Folia)
- [Gale](https://github.com/GaleMC/Gale)

## Attention
The supports of bukkit plugin are unsafe,Think twice before you adding bukkit plugins.