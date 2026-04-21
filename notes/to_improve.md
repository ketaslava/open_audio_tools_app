# Suggestions for Improvement

## VERY IMPORTANT: The "God Object" Problem (ModelData)
`ModelData` is currently doing too many things: holding UI state, acting as a navigation controller, and serving as a callback mediator for dozens of disparate actions (Save, Load, Rename, UI events).
- **Issue**: As the app grows, this file will become impossible to maintain.
- **Suggestion**: Split `ModelData` into smaller, feature-specific ViewModels or State holders (e.g., `RecorderState`, `NavigationState`, `FilesState`). Use a proper Event/Intent system instead of manual `assignCallback` methods.

## VERY IMPORTANT: Processing Pipeline Monolith
`AudioProcessor.processData` calculates every single metric for every chunk of audio.
- **Issue**: This is extremely CPU-intensive and unnecessary if the user is only looking at one specific chart (e.g., just Pitch).
- **Suggestion**: Implement a "Pull" or "On-Demand" processing architecture. Only trigger algorithms whose outputs are currently required by the active UI page. This aligns with your goal of adding AI, which will be even more resource-heavy.

## Navigation Management
The navigation is handled by a large `when` statement in `UserInterface.kt` and manual string constants.
- **Issue**: This is error-prone (typos in strings) and difficult to track as the number of pages increases.
- **Suggestion**: Use an `Enum` or `Sealed Class` for Page types. Consider using a dedicated navigation library or a simpler "Router" component to decouple page switching from the main UI structure.

## Performance: Audio Data Handling
In `Recorder.kt`, you are converting `ShortArray` to `MutableList<Float>` and then to `FloatArray` on every callback.
- **Issue**: This creates significant GC pressure (allocating and discarding many objects), which can cause UI stutters.
- **Suggestion**: Perform the conversion in-place or use a pre-allocated `FloatArray` buffer. Avoid `MutableList` in the high-frequency audio path.

## Dependency Management
Components are manually instantiated in `App.kt` and `Main.kt`.
- **Issue**: This makes it hard to swap implementations (e.g., for testing or for your planned C++ transition).
- **Suggestion**: Consider a lightweight Dependency Injection (DI) framework like Koin, or at least a simple "Service Locator" pattern to manage the lifecycle of your singletons.

## Algorithmic Efficiency
You mentioned moving to C++.
- **Suggestion**: Before moving to C++, ensure your Kotlin algorithms are using vectorized operations where possible. When you do move to C++, use JNI or KMP's C-interop carefully to avoid the overhead of crossing the "bridge" too frequently. Batch processing is your friend here.
