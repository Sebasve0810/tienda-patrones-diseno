# Tienda en Línea — Patrones de Diseño GoF

Sistema de tienda en línea en **Java** que implementa **6 patrones de diseño GoF** en un solo proyecto integrado: Singleton, Factory Method, Strategy, Adapter, Observer y Command.

![Java](https://img.shields.io/badge/Java-8+-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Design Patterns](https://img.shields.io/badge/Patterns-6%20GoF-6f42c1?style=flat)
![Payments](https://img.shields.io/badge/Payments-PSE%20%7C%20PayU%20%7C%20PayPal-00a651?style=flat)

---

## Descripción

Implementación de un sistema de pedidos que integra múltiples patrones de diseño para resolver problemas reales de arquitectura de software: configuración global, creación de objetos, políticas de descuento, integración con APIs de pago externas, notificaciones multicanal e historial de operaciones con soporte de deshacer.

---

## Patrones implementados

| Patrón | Clase | Descripción |
|---|---|---|
| **Singleton** | `ConfiguracionTienda` | Configuración global única (IVA, envío, moneda) |
| **Factory Method** | `ProductoFactory` | Crea Electrónicos, Ropa y Libros con reglas propias |
| **Strategy** | `DescuentoStrategy` | Políticas Regular, Premium y VIP intercambiables |
| **Adapter** | `IPagoAdapter` | Unifica PayPal, PSE, PayU y Transferencia Bancaria |
| **Observer** | `Observador` | Notificaciones por Email y SMS desacopladas del pedido |
| **Command** | `Historial` | Historial de operaciones con soporte de *undo* |

---

## Estructura del proyecto

```
src/
├── MainDemo.java
└── tienda/
    ├── config/
    │   └── ConfiguracionTienda.java      ← Singleton
    ├── producto/
    │   ├── Producto.java
    │   ├── ProductoFactory.java           ← Factory Method
    │   ├── ProductoElectronico.java
    │   ├── ProductoRopa.java
    │   └── ProductoLibro.java
    ├── descuento/
    │   ├── DescuentoStrategy.java         ← Strategy
    │   ├── DescuentoRegular.java
    │   ├── DescuentoPremium.java
    │   └── DescuentoVIP.java
    ├── pago/
    │   ├── IPagoAdapter.java              ← Adapter
    │   ├── PaypalAdapter.java
    │   ├── PSEAdapter.java
    │   ├── PayUAdapter.java
    │   ├── TransferenciaAdapter.java
    │   └── apis/                          ← APIs externas simuladas
    │       ├── PaypalAPI.java
    │       ├── PSEAPI.java
    │       ├── PayUAPI.java
    │       └── TransferenciaAPI.java
    ├── notificacion/
    │   ├── Observador.java                ← Observer
    │   ├── NotificacionEmail.java
    │   └── NotificacionSMS.java
    ├── core/
    │   └── Pedido.java
    └── command/
        ├── Operacion.java                 ← Command
        ├── OperacionCrearPedido.java
        ├── OperacionCancelarPedido.java
        └── Historial.java
```

---

## Ejecución

### Prerrequisitos
- Java 8 o superior
- IntelliJ IDEA, Eclipse o VSCode con extensión Java

### Pasos

```bash
git clone https://github.com/Sebasve0810/tienda-patrones-diseno.git
cd tienda-patrones-diseno
javac -d out src/**/*.java src/*.java
java -cp out MainDemo
```

### Salida esperada

```
Bruto: 255000.0
Impuestos: 50250.0
Envío: 22000.0
Total con descuento: 277250.0
[PAYPAL] cobrando 277250.0 COP
[EMAIL] a cliente@correo.com | Pedido abcd1234 -> Pago aprobado por 277250.0 COP
[SMS] a +57 3000000000 | Pedido abcd1234 -> Pago aprobado por 277250.0 COP
[CMD] Crear pedido abcd1234
[CMD] Deshacer creación abcd1234
```

---

## Lo que demuestra este proyecto

- Aplicación práctica de **patrones de diseño GoF** en un sistema cohesivo
- **Desacoplamiento** entre módulos de pago, notificación y lógica de negocio
- Integración con métodos de pago del **mercado colombiano** (PSE, PayU)
- **Extensibilidad** real — agregar un nuevo método de pago o canal de notificación no requiere modificar el núcleo del sistema

---

## Autor

**Sebastián Velasquez**
Systems Engineering @ Pontificia Universidad Javeriana

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sebastian-velasquez-73662721a)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white)](https://github.com/Sebasve0810)

---

*Proyecto académico — Introducción a la Ingeniería de Software | Ingeniería de Sistemas, Javeriana 2025*
