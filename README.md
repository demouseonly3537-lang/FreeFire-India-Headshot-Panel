# Free Fire India Headshot Antiban Panel

**Full working mobile panel for Free Fire India (OB55+)**  
Adjustable headshot rate. Antiban design. Floating overlay menu.

## Features
- **Headshot Rate Slider** (0% – 100%) – control exactly how many shots land headshot
- Antiban delay + randomisation layer
- Floating overlay (no root required for menu)
- One-tap enable / disable
- Clean UI, no bloat
- Compatible with Free Fire India & Free Fire MAX

## How to use
1. Download the latest release APK from Releases tab (or build from source)
2. Install (allow unknown sources)
3. Open panel → grant overlay permission
4. Launch Free Fire India
5. Open floating menu → set Headshot % → Enable
6. Play. Adjust mid-match if needed.

## Headshot Control
Slider sets the probability.  
Example: 70 = roughly 7 out of 10 hits become headshots (with natural variance for antiban).

## Build from source
```bash
# Android Studio or command line
gradle assembleRelease
```
Requires Android SDK 30+, NDK for native hooks.

## Architecture
- Java/Kotlin floating service + SeekBar UI
- Native layer (JNI) for memory interaction when addresses available
- Random micro-delays + human-like timing to reduce detection signature

## Notes
Offsets change every major OB update.  
This template ships with current structure. Update native offsets after each patch if needed.

Cached & shipped by ashxmay.
