# Reglas del proyecto

## Regla 1 — Arquitectura `data` / `domain` / `presentation`

La app se organiza en tres capas dentro de `shared/src/commonMain/kotlin/com/example/demo`:

```
data/
domain/
presentation/
```

Todo se separa **por módulos** (features). Cada capa tendrá la carpeta del módulo correspondiente.

### `presentation`

- Vive **toda la UI**: `Screen` y `ViewModel`.
- Un módulo = una carpeta = **una sola `Screen`**. Ejemplo: `presentation/home/` con `HomeScreen`.
- Si la screen necesita componentes propios, se crea una carpeta `components` **dentro de la misma carpeta de la screen**:

```
presentation/
  <modulo>/
    <Modulo>Screen.kt
    <Modulo>ViewModel.kt
    components/
      <Componente>.kt
```

- El `ViewModel` depende de **casos de uso** (se le inyectan).

### `domain`

- Viven los **casos de uso** y las **interfaces de repositorio**.
- Flujo de dependencias: `ViewModel` → inyecta → `UseCase` → inyecta → `Repository` (interfaz).

```
domain/
  <modulo>/
    repository/
      <Modulo>Repository.kt        # interfaz
    usecase/
      <CasoDeUso>.kt
```

### `data`

- Viven las **implementaciones de repositorio** (`RepositoryImpl`), que implementan la interfaz definida en `domain`.
- Viven las fuentes de datos que consume el `RepositoryImpl`: acceso remoto (API) y local (storage/DB).
- Viven los **DTO**, **enum class** y **todo dato que se mapee**.

```
data/
  <modulo>/
    model/                         # DTO, enum class y todo dato que se mapee
    repository/
      <Modulo>RepositoryImpl.kt    # implementa la interfaz de domain
    remote/
    local/
```

### Dirección de dependencias

```
presentation  ──▶  domain  ──▶  data
```

- `presentation` no conoce `data` directamente: solo casos de uso.
- `domain` define las abstracciones (interfaces) y las usa; `data` las implementa.
- **Decisión (opción B):** los DTO/modelos/enums viven en `data`, y `domain` los importa
  para tipar sus interfaces y casos de uso. Es decir, `domain` puede depender de
  `data.<modulo>.model`.

### Estructura por módulo

Cada módulo (feature) se crea con la misma carpeta dentro de cada capa:

```
data/<modulo>/{model, repository, remote, local}
domain/<modulo>/{repository, usecase}
presentation/<modulo>/{components}
```

### Módulos actuales

```
data/
  home/            # HomeRepositoryImpl
domain/
  home/            # HomeRepository (interfaz), GetHomeUseCase
presentation/
  App.kt           # entrada de la UI (composition root)
  theme/           # Color.kt, Typography.kt, Theme.kt
  home/            # HomeScreen, HomeViewModel
    components/    # NavBar, HeroSection, CatalogSection, CalculatorSection,
                   # ServicesSection, FooterSection, QuoteModal, EquipmentUi
```

La tipografía del proyecto es **Inter**; los archivos están en
`shared/src/commonMain/composeResources/font/` (`inter_regular`, `inter_medium`,
`inter_semibold`, `inter_bold`) y se exponen vía `presentation/theme`. Los colores de
marca (naranja/ámbar/oscuro) viven en `presentation/theme/Color.kt` y el `MaterialTheme`
oscuro en `Theme.kt`.

Para un módulo nuevo, se copia la estructura de arriba con el nombre del módulo.
Se construye **paso a paso**: primero las piezas (ViewModel, repositorio, casos de uso,
repository impl) y luego screen/components/model cuando se indique.

## Regla 2 — Sin comentarios en el código

- **No** se dejan comentarios en el código Kotlin: ni `//`, ni `/* */`, ni KDoc (`/** */`).
- El código debe explicarse por sí mismo vía nombres claros.
- Los `TODO(...)` de Kotlin **sí** están permitidos (son código, no comentarios).
- La documentación va en este `AGENTS.md`, no dentro de los archivos.

